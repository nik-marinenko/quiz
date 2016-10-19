import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Класс "Вопрос викторины"
 */
class Question {

    /**
     * Свойство Вопрос
     */
    private String question;

    /**
     * Свойство Список вариантов ответов на вопрос
     */
    private List<String> answers;

    /**
     * Свойство Ответ на вопрос, полученный от пользователя
     */
    private int actualAnswer = -1;

    /**
     * Свойство Правильный ответ на вопрос
     */
    private int validAnswer;

    /**
     * Конструктор Вопроса
     * @param question текст вопроса
     */
    public Question(String question){
        // Устанавливаем текст вопроса
        this.question = question;
        // Создаём пустой список для вариантов ответа
        this.answers = new ArrayList<String>();
    }

    /**
     * Добавить текст варианта ответа
     * @param answer текст варианта ответа
     */
    public void addAnswer(String answer){
        this.answers.add(answer);
    }

    /**
     * Установить вариант правильного ответа
     * @param validAnswer порядковый номер правильного ответа в списке вариантов ответа
     */
    public void setValidAnswer(int validAnswer){
        this.validAnswer = validAnswer;
    }

    /**
     * Получить текст вопроса
     * @return текст вопроса
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Получить текст правильного ответа из списка с вариантами ответов
     * @return текст правильного ответа
     */
    public String getValidAnswer(){
        return this.answers.get(this.validAnswer);
    }

    /**
     * Зафиксировать ответ полученный от пользователя
     * @param actualAnswer вариант полученный от пользователя
     */
    public void setActualAnswer(int actualAnswer){
        this.actualAnswer = actualAnswer;
    }

    /**
     * Проверить правильно ли ответил пользователь
     * @return правильный ли был ответ
     */
    public boolean isValid(){
        // совпадает ли ответ полученный от пользователя с правильным ответом
        return this.actualAnswer == this.validAnswer;
    }

    /**
     * Задать вопрос пользователю
     */
    public void ask(){

        // Выводим текст вопроса
        System.out.println(this.question);
        System.out.println("-----------------------");

        // Проходим по всем вариантам ответа
        for (int i = 0; i < this.answers.size(); i++) {
            // Форматируем вариант ответа, нумеруя их
            String formattedAnswer = String.format("%d. %s", i, this.answers.get(i));
            // Выводим вариант ответа
            System.out.println(formattedAnswer);
        }

        readAnswer();
    }

    /**
     * Принять ответ от пользователя
     */
    private void readAnswer() {

        // До тех пор пока пользователь не введёт корректный ответ на вопрос
        do {
            // Принимаем ответ от пользователя
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Введите ответ: ");

            try {
                this.actualAnswer = keyboard.nextInt();
            }catch(InputMismatchException ex){
                // пользователь ввёл не число
                this.actualAnswer = -1;
            }
        }while(this.actualAnswer < 0 || this.actualAnswer > this.answers.size() -1);

    }
}