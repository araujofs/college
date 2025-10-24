import { Component } from '@angular/core'
import { TaskColumn } from './components/task-column/task-column'

@Component({
  selector: 'tasks',
  imports: [TaskColumn],
  templateUrl: './tasks.html',
  styleUrl: './tasks.css',
})
export class Tasks {
  columns = ['Para fazer', 'Em andamento', 'Concluídas']
}
