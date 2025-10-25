import { Component, inject } from '@angular/core'
import { TaskColumn } from './components/task-column/task-column'
import { TaskFormModal } from './components/task-form-modal/task-form-modal'
import { TaskModal } from './services/task-modal/task-modal'

@Component({
  selector: 'tasks',
  imports: [TaskColumn, TaskFormModal],
  templateUrl: './tasks.html',
  styleUrl: './tasks.css',
})
export class Tasks {
  protected modal = inject(TaskModal)
  columns = ['Para fazer', 'Em andamento', 'Concluídas']
}
