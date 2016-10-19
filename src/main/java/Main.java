public class Main {

    public static void main(String [] args){

        // Создаём 1-й вопрос викторины
        Question question1 = new Question("Какого цвета у меня кот ?");
        // Добавляем варианты ответов
        question1.addAnswer("синий");
        question1.addAnswer("зелёный");
        question1.addAnswer("красный");
        question1.addAnswer("рыжий");
        // Устанавливаем правильный ответ (учитывая, что нумерация в списке идёт начиная с 0)
        question1.setValidAnswer(3);


        // Создаём 2-й вопрос викторины
        Question question2 = new Question("Как зовут моего брата ?");
        // Добавляем варианты ответов
        question2.addAnswer("Петя");
        question2.addAnswer("Вася");
        question2.addAnswer("Миша");
        question2.addAnswer("Даша");
        // Устанавливаем правильный ответ (учитывая, что нумерация в списке идёт начиная с 0)
        question2.setValidAnswer(2);


        // Создаём новую виторину
        Quiz quiz = new Quiz();
        // Добавляем вопросы, которые мы приготовили для викторины
        quiz.addQuestion(question1);
        quiz.addQuestion(question2);

        // Задаём вопросы и получаем на них ответы
        for (Question question : quiz.getQuestions()) {
            question.ask();
        }

        // Выводим результаты викторины
        quiz.results();

    }
}
