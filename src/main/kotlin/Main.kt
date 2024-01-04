class DigiJobsApp {
    private val jobsList = mutableListOf<Job>()

    fun startApp() {
        var userInput: Int

        do {
            printMenu()
            print("Enter your choice (1-4): ")
            userInput = readLine()?.toIntOrNull() ?: 0

            when (userInput) {
                1 -> addNewJob()
                2 -> printAllJobs()
                3 -> deleteJob()
                4 -> println("Exiting DigiJobsApp. Goodbye!")
                else -> println("Invalid input. Please enter a number between 1 and 4.")
            }

        } while (userInput != 4)
    }

    private fun printMenu() {
        println("======== DIGIJOBS ========")
        println("Please choose following commands:")
        println("1. Add new job")
        println("2. Print all jobs")
        println("3. Delete job")
        println("4. Exit")
    }

    private fun addNewJob() {
        println("Enter job details:")
        print("Job ID: ")
        val jobId = readLine()?.toIntOrNull() ?: 0

        print("Job Address: ")
        val jobAddress = readLine() ?: ""

        print("Job Position ID: ")
        val positionId = readLine()?.toIntOrNull() ?: 0

        print("Job Position Name: ")
        val positionName = readLine() ?: ""

        val jobPosition = JobPosition(positionId, positionName)
        val newJob = Job(jobId, jobAddress, jobPosition)
        jobsList.add(newJob)

        println("Job added successfully.")
        println()
    }

    private fun printAllJobs() {
        if (jobsList.isEmpty()) {
            println("No jobs available.")
        } else {
            println("All Jobs:")
            for (job in jobsList) {
                println("Job ID: ${job.jobId}, Job Address: ${job.jobAddress}, " +
                        "Position ID: ${job.jobPosition.jobPositionId}, " +
                        "Position Name: ${job.jobPosition.jobPositionName}")
                println("----------------------------------------------------------")
            }
        }
        println()
    }

    private fun deleteJob() {
        print("Enter the Job ID to delete: ")
        val jobIdToDelete = readLine()?.toIntOrNull() ?: 0

        val jobToRemove = jobsList.find { it.jobId == jobIdToDelete }

        if (jobToRemove != null) {
            jobsList.remove(jobToRemove)
            println("Job deleted successfully.")
        } else {
            println("Job with ID $jobIdToDelete not found.")
        }
        println()
    }
}

fun main() {
    val digiJobsApp = DigiJobsApp()
    digiJobsApp.startApp()
}
