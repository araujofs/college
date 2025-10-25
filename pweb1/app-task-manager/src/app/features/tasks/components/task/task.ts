import { Component, inject, input } from '@angular/core'
import { TaskData } from '../../models/task-data.model'
import { TaskModal } from '../../services/task-modal/task-modal'

@Component({
  selector: 'task',
  imports: [],
  templateUrl: './task.html',
  styleUrl: './task.css',
})
export class Task {
  task = input<TaskData>()
}
