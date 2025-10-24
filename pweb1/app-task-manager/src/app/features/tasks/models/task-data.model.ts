export interface TaskData {
  title: string
  dueDate: Date
  level: "low" | "medium" | "high"
  description: string
  status: TaskStatus 
}

export type TaskStatus = "todo" | "doing" | "done"