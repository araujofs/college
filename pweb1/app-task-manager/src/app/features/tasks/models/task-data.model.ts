export interface TaskData {
  id: number
  title: string
  dueDate: string 
  level: TaskLevel 
  description: string | null
  status: TaskStatus 
}

export type TaskStatus = "todo" | "doing" | "done"
export type TaskLevel = 'low' | 'medium' | 'high'