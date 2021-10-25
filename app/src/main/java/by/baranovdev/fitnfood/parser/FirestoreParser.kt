package by.baranovdev.fitnfood.parser

import by.baranovdev.fitnfood.database.entity.Exercise
import by.baranovdev.fitnfood.database.entity.Program

abstract class FirestoreParser {
    companion object {
        fun fromProgramResponseToProgram(map: Map<String, Any>, key:String): Program {
            val fields: Array<String> = arrayOf("", "", "", "", "", "")
            for (mapKey in map.entries) {
                when (mapKey.key) {
                    "description" -> fields[5] = map[mapKey.key].toString()
                    "exerciseListString" -> fields[4] = map[mapKey.key].toString()
                    "iconUrl" -> fields[2] = map[mapKey.key].toString()
                    "name" -> fields[0] = map[mapKey.key].toString()
                    "repeats" -> fields[3] = map[mapKey.key].toString()
                    "xp" -> fields[1] = map[mapKey.key].toString()
                }
            }
            return Program(
                fields[0],
                fields[1].toInt(),
                fields[2],
                fields[3].toInt(),
                fields[4],
                fields[5],
                key
            )
        }

        fun fromProgramToProgramResponse(program: Program): Map<String, String> {
            return hashMapOf(
                "description" to program.description.orEmpty(),
                "exerciseListString" to program.exerciseListString.orEmpty(),
                "iconUrl" to program.iconUrl.orEmpty(),
                "name" to program.name.orEmpty(),
                "repeats" to program.repeats?.or(0).toString(),
                "xp" to program.xp?.or(0).toString(),
                "key" to program.key.orEmpty()
            )
        }

        fun fromExerciseListStringToExerciseList(
            string: String,
            oldList: List<Exercise>
        ): List<Exercise> {
            val array = string.split('|')
            val newList = ArrayList<Exercise>()
            for (c in array) {
                for (ex in oldList) {
                    if (ex.id == c.toInt()) newList.add(ex)
                }
            }
            return newList
        }

        fun fromExerciseListToExerciseListString(
            currentList: List<Exercise>
        ): String {
            var currentString = ""
            for (ex in currentList) {
                currentString += "${ex.id}"
                if (currentList.indexOf(ex) != currentList.lastIndex)
                    currentString += "|"
            }
            return currentString
        }

        fun fromExerciseResponseToExercise(map: Map<String, Any>, key: String): Exercise {
            val fields: Array<String> = arrayOf("", "")
            for (mapKey in map.keys) {
                when (mapKey) {
                    "name" -> fields[5] = map[key].toString()
                    "url" -> fields[4] = map[key].toString()
                }
            }
            return Exercise(
                fields[0],
                fields[1],
                key
            )
        }

        fun fromExerciseToExerciseResponse(exercise: Exercise): Map<String, String> {
            return hashMapOf(
                "name" to exercise.name.orEmpty(),
                "url" to exercise.url.orEmpty(),
                "key" to exercise.key.orEmpty()
            )
        }
    }
}