import { Component, input } from '@angular/core';
import { Task } from '../task/task';
import { TaskData } from '../../models/task-data.model';

@Component({
  selector: 'task-column',
  imports: [Task],
  templateUrl: './task-column.html',
  styleUrl: './task-column.css'
})
export class TaskColumn {
  title = input<string>()
  tasks = input<TaskData[]>()
}
