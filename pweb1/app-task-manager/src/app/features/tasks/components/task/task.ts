import { Component, computed, inject, input } from '@angular/core'
import { TaskData } from '../../models/task-data.model'
import { Data } from '../../services/data/data'
import { TaskModal } from '../../services/task-modal/task-modal'

@Component({
  selector: 'task',
  imports: [],
  templateUrl: './task.html',
  styleUrl: './task.css',
})
export class Task {
  tasksService = inject(Data)
  modalService = inject(TaskModal)

  data = input.required<TaskData>()
  level = computed(
    () =>
      ({
        low: 'Baixa',
        medium: 'Média',
        high: 'Alta',
      }[this.data().level])
  )
  localeDate = computed(() => {
    const dueDate = new Date(this.data().dueDate)
    return dueDate.toLocaleDateString('pt-br')
  })
  proximityColor = computed(() => {
    const dueDate = Date.parse(this.data().dueDate)
    const today = new Date()
    const diff = Math.floor((-(-today) - -(-dueDate)) / (1000 * 60 * 60 * 24))
    
    if (diff < -7) return 'bg-green-600'
    if (diff <= -4) return 'bg-amber-500'
    if (diff <= -1) return 'bg-red-500'
    if (diff <= 0) return 'bg-violet-500'
    return 'bg-zinc-400'
  })
}
