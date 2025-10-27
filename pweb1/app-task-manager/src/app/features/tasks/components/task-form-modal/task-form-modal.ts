import { Component, inject } from '@angular/core'
import { TaskModal } from '../../services/task-modal/task-modal'
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms'
import { Data } from '../../services/data/data'
import { TaskLevel, TaskStatus } from '../../models/task-data.model'

@Component({
  selector: 'task-form-modal',
  imports: [ReactiveFormsModule],
  templateUrl: './task-form-modal.html',
  styleUrl: './task-form-modal.css',
})
export class TaskFormModal {
  protected modal = inject(TaskModal)
  protected tasksService = inject(Data)
  private formBuilder = inject(FormBuilder)

  taskForm = this.formBuilder.nonNullable.group({
    title: [this.modal.modalEditTask()?.title ?? '', Validators.required],
    dueDate: [this.modal.modalEditTask()?.dueDate ?? '', Validators.required],
    level: [this.modal.modalEditTask()?.level ?? ('low' as TaskLevel), Validators.required],
    description: new FormControl(this.modal.modalEditTask()?.description ?? ''),
  })

  onSubmit() {
    if (!this.taskForm.valid)
      return

    const formValue = this.taskForm.getRawValue()
    const oldTask = this.modal.modalEditTask()

    if (oldTask) {
      const newTask = {
        ...oldTask,
        ...formValue,
        dueDate: formValue.dueDate.replace(/-/g, '\/')
      }

      this.tasksService.editTask(newTask)
    }

    if (!oldTask) {
      const newTask = {
        ...formValue,
        status: 'todo' as TaskStatus,
        dueDate: formValue.dueDate.replace(/-/g, '\/')
      }

      this.tasksService.createTask(newTask)
    }

    this.modal.closeModal()
  }
}
