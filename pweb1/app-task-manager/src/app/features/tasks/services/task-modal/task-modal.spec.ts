import { TestBed } from '@angular/core/testing'

import { TaskFormModal } from './task-modal'

describe('TaskFormModal', () => {
  let service: TaskFormModal

  beforeEach(() => {
    TestBed.configureTestingModule({})
    service = TestBed.inject(TaskFormModal)
  })

  it('should be created', () => {
    expect(service).toBeTruthy()
  })
})
