var gulp = require('gulp');
var jshint = require('gulp-jshint');
var jscs = require('gulp-jscs');

//Ignore all .min files
gulp.task('vet', function () {
    console.log('\n--> Vetting all js files\n');
    return gulp
        .src(['./src/**/*.js',
            './*.js',
            '!./src/**/*.min.js'])
        .pipe(jscs())
        .pipe(jshint())
        .pipe(jshint.reporter('jshint-stylish', {verbose:true}));
});


gulp.task('hello-world', function () {
    console.log('Hello Rana');
});

