var gulp 	= 	require('gulp'),
	sass	= 	require('gulp-sass');


function recompile_sass() {
	gulp.src('./src/main/resources/sass/styles.scss')
		.pipe(sass()
		.on('error', sass.logError))
		.pipe(gulp.dest('./src/main/webapp/static/'));
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