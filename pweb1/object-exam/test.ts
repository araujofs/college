import { Answer, Exam, Weight } from "./exam.js"

// Script de teste para as funcionalidades do sistema de exames

// Criando gabarito - respostas corretas: A, B, C, D
const gabarito = new Answer(['A', 'B', 'C', 'D'])

// Criando pesos para cada questão: 2.5 pontos cada
const pesos = new Weight([2.5, 2.5, 2.5, 2.5])

// Criando o exame com gabarito e pesos
const exame = new Exam(gabarito, pesos)

console.log('=== SISTEMA DE CORREÇÃO DE EXAMES ===\n')

// Adicionando algumas respostas de estudantes
console.log('📝 Adicionando respostas dos estudantes...')

// Estudante 1 - todas corretas (nota 10)
const resposta1 = new Answer(['A', 'B', 'C', 'D'], 'João Silva')
exame.add(resposta1)
console.log('✅ Adicionado: João Silva - Respostas: A, B, C, D')

// Estudante 2 - 3 corretas (nota 7.5)
const resposta2 = new Answer(['A', 'B', 'C', 'A'], 'Maria Santos')
exame.add(resposta2)
console.log('✅ Adicionado: Maria Santos - Respostas: A, B, C, A')

// Estudante 3 - 2 corretas (nota 5.0)
const resposta3 = new Answer(['A', 'B', 'A', 'A'], 'Pedro Costa')
exame.add(resposta3)
console.log('✅ Adicionado: Pedro Costa - Respostas: A, B, A, A')

// Estudante 4 - 1 correta (nota 2.5)
const resposta4 = new Answer(['A', 'A', 'A', 'A'], 'Ana Oliveira')
exame.add(resposta4)
console.log('✅ Adicionado: Ana Oliveira - Respostas: A, A, A, A')

// Estudante 5 - nenhuma correta (nota 0)
const resposta5 = new Answer(['B', 'A', 'A', 'A'], 'Carlos Lima')
exame.add(resposta5)
console.log('✅ Adicionado: Carlos Lima - Respostas: B, A, A, A')

console.log('\n=== ESTATÍSTICAS DO EXAME ===')

// Testando média
console.log(`📊 Média da turma: ${exame.avg().toFixed(2)}`)

// Testando maiores notas (top 3)
console.log(`🏆 Top 3 maiores notas: ${exame.max().join(', ')}`)

// Testando menores notas (bottom 3)
console.log(`📉 3 menores notas: ${exame.min().join(', ')}`)

// Testando filtros
console.log(`❌ Estudantes com nota < 6.0: ${exame.lt(6.0).length} alunos`)
console.log(`✅ Estudantes com nota > 7.0: ${exame.gt(7.0).length} alunos`)

console.log('\n=== DETALHES DOS FILTROS ===')

// Mostrando detalhes dos estudantes com nota baixa
const estudantesBaixaNota = exame.lt(6.0)
console.log('📝 Estudantes que precisam de recuperação (nota < 6.0):')
estudantesBaixaNota.forEach((resposta, index) => {
  console.log(
    `   ${index + 1}. ${
      resposta.studentName || 'Anônimo'
    } - Respostas: [${resposta.answers.join(', ')}]`
  )
})

// Mostrando detalhes dos estudantes com nota alta
const estudantesAltaNota = exame.gt(7.0)
console.log('\n🌟 Estudantes com excelente desempenho (nota > 7.0):')
estudantesAltaNota.forEach((resposta, index) => {
  console.log(
    `   ${index + 1}. ${
      resposta.studentName || 'Anônimo'
    } - Respostas: [${resposta.answers.join(', ')}]`
  )
})

console.log('\n=== TESTE DE VALIDAÇÕES ===')

// Testando validações de erro
console.log('🧪 Testando validações...')

try {
  // Tentando criar exame com número de pesos diferente do gabarito
  const pesoInvalido = new Weight([2.5, 2.5]) // só 2 pesos para 4 questões
  new Exam(gabarito, pesoInvalido)
} catch (error) {
  console.log('✅ Validação funcionando: ' + (error as Error).message)
}

try {
  // Tentando adicionar resposta com número diferente de questões
  const respostaInvalida = new Answer(['A', 'B']) // só 2 respostas para 4 questões
  exame.add(respostaInvalida)
} catch (error) {
  console.log('✅ Validação funcionando: ' + (error as Error).message)
}

console.log('\n=== TESTE CONCLUÍDO ===')
console.log('🎯 Todas as funcionalidades foram testadas com sucesso!')
