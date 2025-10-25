import { Component, inject } from '@angular/core';
import { TaskModal } from '../../services/task-modal/task-modal';

@Component({
  selector: 'task-form-modal',
  imports: [],
  templateUrl: './task-form-modal.html',
  styleUrl: './task-form-modal.css',
})
export class TaskFormModal {
  protected modal = inject(TaskModal)
}
