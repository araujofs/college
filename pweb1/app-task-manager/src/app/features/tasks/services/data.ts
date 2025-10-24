import { effect, Injectable, signal } from '@angular/core'
import { TaskData, TaskStatus } from '../models/task-data.model'

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

  createTask(task: TaskData) {
    this.tasks.update((oldTasks) => {
      oldTasks['tasks-todo'].push(task)

      return oldTasks
    })
  }
}
