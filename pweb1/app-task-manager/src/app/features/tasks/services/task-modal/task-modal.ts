import { Injectable, signal } from '@angular/core';
import { TaskData } from '../../models/task-data.model';

@Injectable({
  providedIn: 'root'
})
export class TaskModal {
  modalIsOpen = signal(false) 
  modalEditTask = signal<TaskData | undefined>(undefined)

  openModal(): void
  openModal(task: TaskData): void

  openModal(task?: TaskData) {
    this.modalIsOpen.set(true)
    this.modalEditTask.set(task)
  }

  closeModal() {
    this.modalIsOpen.set(false)
    this.modalEditTask.set(undefined)
  }
}
