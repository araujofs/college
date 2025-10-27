import { Component, computed, inject, input } from '@angular/core';
import { Task } from '../task/task';
import { TaskData, TaskStatus } from '../../models/task-data.model';
import { Data } from '../../services/data/data';

export interface ColumnData {
  title: string
  status: TaskStatus
}

@Component({
  selector: 'task-column',
  imports: [Task],
  templateUrl: './task-column.html',
  styleUrl: './task-column.css'
})
export class TaskColumn {
  private taskData = inject(Data)
  column = input.required<ColumnData>()
  tasks = computed(() => this.taskData.tasks()[`tasks-${this.column().status}`])
}
