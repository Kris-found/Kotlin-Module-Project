import java.util.Scanner

class CreateArchive(val name: String){
    private val notes = mutableListOf<Note>()
    private val scanner = Scanner(System.`in`)
    private val menu = General(scanner)

    fun manageArchive(){

        while(true) {

            val input = menu.menuOutput(
                "Список заметок в архиве ${this.name}",
                listOf("Создать заметку", "Открыть заметки"),
                "Назад"
            )

            when(input){
                0 -> return
                1 -> createNote()
                2 -> selectNotes()
                else -> println("Некорректный ввод. Попробуйте снова")
            }
        }

    }

    fun createNote() {

        val nameNote = menu.emptyInput("Введите название заметки")

        val text = menu.emptyInput("Введите текст заметки")
        notes.add(Note(nameNote, text))

    }


    private fun selectNotes() {
        if (notes.isEmpty()) {
            println("Пока нет созданных заметок")
            return
        }
        while(true){
            val noteItems = notes.map { it.name }
            val input = menu.menuOutput(
                "Выберите заметку",
                noteItems,
                "Назад"
            )


            when(input){
                0 -> return
                in 1..notes.size -> {
                    val selectedNote = notes[input!! - 1]
                    println("Выбрана заметка: ${selectedNote.name}")
                    println("Текст заметки:\n ${selectedNote.text}")
                }
                else -> println("Некорректный ввод. Попробуйте снова")
            }
        }
    }
}


