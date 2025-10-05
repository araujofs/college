export class Exam {
  #weight: Weight
  #answer: Answer
  #answers: Answer[] = []
  #grades: number[] = []

  constructor(answer: Answer, weight: Weight) {
    console.log(answer.name)
    if ((answer.answers.length !== weight.weights.length))
      throw new Error("Invalid arguments to create exam (weights and answers must have the same length")

    if (answer.name)
      throw new Error('Invalid answer (exam answer key must have empty name)')

    this.#answer = answer
    this.#weight = weight 
  }

  add(answer: Answer) {
    if (answer.answers.length !== this.#answer.answers.length)
      throw new Error("Invalid answer (too many/few questions)")

    if (!answer.name)
      throw new Error('Invalid answer (answer must have a name)')

    this.#answers.push(answer)
    this.#grades.push(this.#gradeExam(answer))
  }

  avg() {
    return this.#grades.reduce((acc, curr) => (acc + curr), 0) / this.#answers.length
  }

  min() {
    return this.#grades.sort((a, b) => b - a).slice(0, 3)
  }

  max() {
    return this.#grades.sort((a, b) => a - b).slice(0, 3)
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
  #name: string 
  #answers: string[]

  constructor(answers: string[], name = '') {
    this.#answers = answers
    this.#name = name 
  }

  get name() {
    return this.#name
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

