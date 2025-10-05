export class Exam {
  #weight: Weight
  #answer: Answer
  #answers: Answer[] = []

  constructor(answer: Answer, weight: Weight) {
    if ((answer.answers.length !== weight.weights.length) || (answer.studentName !== undefined))
      throw new Error("Invalid arguments to create exam")

    this.#answer = answer
    this.#weight = weight 
  }

  add(answer: Required<Answer>) {
    if (answer.answers.length !== this.#answer.answers.length)
      throw new Error("Invalid answer (too many/few questions)")

    this.#answers.push(answer as Answer)
  }

  avg() {
    return this.#answers.reduce((acc, curr) => (acc + this.#gradeExam(curr)), 0) / this.#answers.length
  }

  min() {
    return this.#answers.map((ans) => this.#gradeExam(ans)).sort((a, b) => b - a).slice(0, 3)
  }

  max() {
    return this.#answers.map((ans) => this.#gradeExam(ans)).sort((a, b) => a - b).slice(0, 3)
  }

  lt(limit: number) {
    return this.#answers.filter((ans) => this.#gradeExam(ans) < limit)
  }

  gt(limit: number) {
    return this.#answers.filter((ans) => this.#gradeExam(ans) > limit)
  }

  #gradeExam(answer: Answer) {
    const answers = answer.answers
    let grade = 0

    for (let i = 0; i < answers.length; i++) {
      if (answers[i] === this.#answer.answers[i]) grade += this.#weight.weights[i] as number
    }

    return grade
  }
}


export class Answer {
  #studentName: string | undefined
  #answers: string[]

  constructor(answers: string[], studentName?: string) {
    this.#answers = answers
    this.#studentName = studentName 
  }

  get studentName() {
    return this.#studentName
  }

  get answers() {
    return this.#answers
  }
}

export class Weight {
  #weights: number[]

  constructor(weights: number[]) {
    this.#weights = weights
  }

  get weights() {
    return this.#weights
  }
}

