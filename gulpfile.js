var gulp 		= 	require('gulp'),
	sass		= 	require('gulp-sass'),
	livereload 	= 	require('livereload');

var STATIC_FOLDER = './src/main/webapp/static/';

function reload() {
	var server = livereload.createServer();
	server.watch(STATIC_FOLDER);
}

function recompile_sass() {
	gulp.src('./src/main/resources/sass/styles.scss')
		.pipe(sass()
		.on('error', sass.logError))
		.pipe(gulp.dest(STATIC_FOLDER));
}

gulp.task('sass', function() {
	recompile_sass();
	gulp.watch('./src/main/resources/sass/**/*.scss', function(e) {
		console.log(new Date() + ' - ' 
				+ e.path);
		recompile_sass();
	});
});

gulp.task('default', ['sass']);