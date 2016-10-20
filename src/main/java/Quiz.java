import java.util.ArrayList;
import java.util.List;

/**
 * Класс "Викторина"
 */
class Quiz{

    /**
     * Свойство Список вопросов викторины
     */
    private List<Question> questions;

    /**
     * Конструктор викторины
     */
    public Quiz(){
        // Создаём пустой список вопросов викторины
        this.questions = new ArrayList<Question>();
    }

    /**
     * Добавление вопроса викторины
     * @param question вопрос викторины
     */
    public void addQuestion(Question question){
        this.questions.add(question);
    }

    /**
     * Получить текущий перечень вопросов викторины
     * @return перечень вопросов
     */
    public List<Question> getQuestions() {
        return questions;
    }

    /**
     * Получить количество вопросов викторины
     * @return количество вопросов
     */
    public int getQuestionsAmount(){
        return this.questions.size();
    }

    /**
     * Вывод результатов викторины
     */
    public void results(){

        System.out.println("-----------------------");
        System.out.println("Результаты викторины:");
        System.out.println("-----------------------");


        // Пробегаемся по всем вопросам викторины
        for (int i = 0; i < this.questions.size(); i++) {

            // Получаем текущий вопрос викторины из общего списка вопросов для его анализа
            Question question = this.questions.get(i);

            // Если ответ на текущий вопрос был правильный
            String formattedResult;
            if (question.isValid()){
                formattedResult = String.format("%d. %s - правильный ответ", i, question.getQuestion());
            } else {
                formattedResult = String.format("%d. %s - неправильный ответ, правильный ответ - %s", i, question.getQuestion(), question.getValidAnswer());
            }

            // Выводим форматированный результат ответа на вопрос
            System.out.println(formattedResult);

        }
    }

    public void go() {
        // Задаём вопросы и получаем на них ответы
        for (Question question : this.questions) {
            question.ask();
        }
    }
}