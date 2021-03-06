import java.io.File

/**
 * Created by simonshapiro on 29/10/15.
 */
object batchSchemaExtract {
  def main(args: Array[String]) {
    if (args.length != 5) {
      println("Usage <data file directory> <file ext> <draft schema directory> <separator> <namespace>")
    }
    else {
      val directory = args(0)
      val fileExtension = args(1)
      val draftsDirectory = args(2)
      val separator = args(3)
      val namespace = args(4)
      val f = new File(directory)
      val l = f.listFiles()
      l.foreach(fl => {
        if(fl.isFile && fl.getName.contains(fileExtension)) {
          println(fl.getCanonicalFile)
          extractDraftSchema.extract(fl.getCanonicalFile.toString, separator, namespace, draftsDirectory+fl.getName.replace(fileExtension,".avsc"))
          println(">>>>>> End")
        }
      })
    }
  }
}
