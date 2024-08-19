import java.util.Scanner

class App {
    private val archives = mutableListOf<CreateArchive>()
    private val scanner = Scanner(System.`in`)
    private val menu = General(scanner)

    fun start() {
        while(true) {

            val input = menu.menuOutput(
                "Добро пожаловать в заметки!\nВыберите необходимое действие и введите соответствующую цифру в консоль",
                listOf("Создать архив", "Выбрать архив"),
                "Выход"
            )



            when (input) {
                0 -> {
                    scanner.close()
                    return
                }
                1 -> createArchive()
                2 -> selectArchive()
                else -> println("Некорректный ввод. Попробуйте снова")
            }
        }
    }

    private fun createArchive() {
        val nameArchive = menu.emptyInput("Веедите название архива")
        archives.add(CreateArchive(nameArchive))
        println("Архив $nameArchive создан!")
    }

    private fun selectArchive() {

        if (archives.isEmpty()) {
            println("Нет созданных архивов. Создайте его прямо сейчас!")
            return
        }

        while (true) {
            val archiveItems = archives.map { it.name }
            val input = menu.menuOutput(
                "Выберите архив",
                archiveItems,
                "Назад"
            )


            when (input) {
                0 -> return
                in 1..archives.size -> {
                    val selectedArchive = archives[input!! - 1]
                    println("Выбран архив: ${selectedArchive.name}")
                    selectedArchive.manageArchive()
                }
                else -> println("Некорректный ввод. Попробуйте снова")
            }

        }

    }
}
