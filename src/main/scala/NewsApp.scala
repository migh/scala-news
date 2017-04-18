import scala.io.Source

import java.text.SimpleDateFormat
import java.util.Calendar

object Main extends App {
    def processLine( line:String, newsSets: List[NewsSet] ) = {
        line match {
            // Must start a new NewsSet, in this case, new email object
            case fromRE() => {
                new NewsSet()
                line
            }
            case sentRE(weekday, month, day, year, hour, minutes, meridian) => {
                val hourStr = if (meridian == "PM") hour.toInt + 12 else hour.toInt
                println(s"$year-$month-$day ${hourStr}:${minutes}")
                line
            }
            case _ => line
        }
    }

    val fromRE = """^From:.*""".r
    // todo: I think java has some library for creating date from string
    // http://stackoverflow.com/questions/5306803/how-to-convert-the-following-string-to-date-or-calendar-object-in-java
    // http://alvinalexander.com/scala/scala-number-nnumeric-date-formatting-casting-examples#scala-date-and-time-examples
    val sentRE = """^Sent:\s*(\w*)\s*,\s*(\w*)\s*(\d*),\s*(\d{4}) (\d{1,2}):(\d{1,2}) ([A|P]M)""".r

    val newsSets = Nil
    val news = Source.fromFile("input.txt")

    news.getLines.foreach((line) => {
        processLine(line, newsSets)
    })

    news.close
}
