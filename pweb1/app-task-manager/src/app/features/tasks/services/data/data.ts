import { effect, Injectable, signal } from '@angular/core'
import { TaskData, TaskStatus } from '../../models/task-data.model'

@Injectable({
  providedIn: 'root',
})
export class Data {
  tasks = signal<{
    'todo': TaskData[]
    'doing': TaskData[]
    'done': TaskData[]
  }>({
    'todo': [],
    'doing': [],
    'done': [],
  })

  constructor() {
    const tasks = localStorage.getItem('tasks')

    if (tasks) {
      this.tasks.set(JSON.parse(tasks))
    }

    effect(() => {
      localStorage.setItem('tasks', JSON.stringify(this.tasks()))
    })
  }

  createTask(task: Omit<TaskData, "id">) {
    const taskWithId = {...task, id: Date.now()}

    this.tasks.update((oldTasks) => {
      oldTasks['todo'].push(taskWithId)

      return {...oldTasks}
    })
  }

  getTaskByStatus(status: TaskStatus) {
    return this.tasks()[status]
  }

  deleteTaskById(id: number, status: TaskStatus) {
    this.tasks.update(oldTasks => {
      oldTasks[status] = oldTasks[status].filter(task => task.id !== id)

      return {...oldTasks}
    })
  }

  editTask(task: TaskData) {
    this.tasks.update(oldTasks => {
      const oldIndex = oldTasks[task.status].findIndex(oldTask => oldTask.id === task.id)

      oldTasks[task.status][oldIndex] = { ...oldTasks[task.status][oldIndex], ...task }
      
      return {...oldTasks}
    })
  }

  changeTaskStatus(id: number, currentStatus: TaskStatus, newStatus: TaskStatus) {
    if (currentStatus === newStatus) return

    this.tasks.update(oldTasks => {
      const taskIndex = oldTasks[currentStatus].findIndex(task => task.id === id)
      const oldTask = oldTasks[currentStatus].splice(taskIndex, 1)[0]

      oldTask.status = newStatus
      oldTasks[newStatus].push(oldTask)

      return {...oldTasks}
    })
  }
}
