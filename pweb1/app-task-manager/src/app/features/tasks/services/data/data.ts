import { effect, Injectable, signal } from '@angular/core'
import { TaskData, TaskStatus } from '../../models/task-data.model'

@Injectable({
  providedIn: 'root',
})
export class Data {
  tasks = signal<{
    'tasks-todo': TaskData[]
    'tasks-doing': TaskData[]
    'tasks-done': TaskData[]
  }>({
    'tasks-todo': [],
    'tasks-doing': [],
    'tasks-done': [],
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
      oldTasks['tasks-todo'].push(taskWithId)

      return {...oldTasks}
    })
  }

  getTaskByStatus(status: TaskStatus) {
    return this.tasks()[`tasks-${status}`]
  }

  deleteTaskById(id: number, status: TaskStatus) {
    this.tasks.update(oldTasks => {
      oldTasks[`tasks-${status}`] = oldTasks[`tasks-${status}`].filter(task => task.id !== id)

      return {...oldTasks}
    })
  }

  editTask(task: TaskData) {
    this.tasks.update(oldTasks => {
      const oldIndex = oldTasks[`tasks-${task.status}`].findIndex(oldTask => oldTask.id === task.id)

      oldTasks[`tasks-${task.status}`][oldIndex] = { ...oldTasks[`tasks-${task.status}`][oldIndex], ...task }
      
      return {...oldTasks}
    })
  }
}
