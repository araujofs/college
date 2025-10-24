import { Component, input } from '@angular/core';
import { TaskData } from '../../models/task-data.model';

@Component({
  selector: 'task',
  imports: [],
  templateUrl: './task.html',
  styleUrl: './task.css',
})
export class Task {
  task = input<TaskData>()
}
