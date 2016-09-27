import groovy.io.FileType
includeTargets << grailsScript("_GrailsInit")

target(main: "List alle files under grails-app. Takes a regular expression as parameter.") {
	def filter = argsMap.params[0]
	def dir = new File("${baseFile}/grails-app/")
	def len  = "${baseFile}".length() +1
	dir.eachFileRecurse (FileType.FILES) { file ->
		def fname = "${file}"[len..-1]
		if(!filter || fname =~ filter){
			println fname
		}
	}

}

setDefaultTarget(main)
