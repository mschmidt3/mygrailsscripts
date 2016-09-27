includeTargets << grailsScript("_GrailsInit")

target(main: "The description of the script goes here!") {
	def cmdline = "git"
	argsMap.params.each{
		if(it.contains(" ")){
			cmdline += " \"${it}\""
		}else{
			cmdline += " ${it}"
		}
	}
	println cmdline
	def process = cmdline.execute()
	process.waitFor()
	println process.text
}

setDefaultTarget(main)
