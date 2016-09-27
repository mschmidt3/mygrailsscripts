import groovy.io.FileType
includeTargets << grailsScript("_GrailsInit")


target(main: "Open File in vim. Filename without extension is sufficient") {
	def vim = "gvim --remote-tab"
	if(grailsEnv == 'development'){
		def files = [:] 
		def fileToOpen = argsMap.params[0]
		if(!new File(fileToOpen).canRead()){
			def dir = new File("${baseFile}/grails-app/")
			dir.eachFileRecurse (FileType.FILES) { file ->
				def fname = file.name[0..(file.name.lastIndexOf('.')-1)]
//				def extension = file.name[(file.name.lastIndexOf('.'))..-1]
				files[fname] = file
				files[file.name] = file
			}
			fileToOpen = files[fileToOpen]
		}

		println "${vim}: ${fileToOpen}"
		"${vim} ${fileToOpen}".execute()
	}else{
		println "vim script can only be run ind development mode"
	}
}


setDefaultTarget(main)
