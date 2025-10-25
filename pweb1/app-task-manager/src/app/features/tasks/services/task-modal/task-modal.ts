import { Injectable, signal } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TaskModal {
  modalIsOpen = signal(false) 

  openModal() {
    this.modalIsOpen.set(true)
  }

  closeModal() {
    this.modalIsOpen.set(false)
  }
}
