// val headerImage = "<http://www.especialistas.com.mx/genericas/images/cabezal_accenture1.jpg>"
// val SubjectRE = """^Subject:.*""".r

class NewsSet() {
    var raw = Nil
    def push(line:String) = {
        this.raw = line::this.raw
    }
}
