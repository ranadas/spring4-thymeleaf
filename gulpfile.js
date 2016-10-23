var gulp = require('gulp');
var jshint = require('gulp-jshint');
var jscs = require('gulp-jscs');
var util = require('gulp-util');

//Ignore all .min files
gulp.task('vet', function () {
    log('\n--> Vetting, Analyzing js files with jscs and Jshint.\n');
    return gulp
        .src(['./src/**/*.js',
            './*.js',
            '!./src/**/*.min.js'])
        .pipe(jscs())
        .pipe(jshint())
        .pipe(jshint.reporter('jshint-stylish', {verbose: true}));
});


gulp.task('hello-world', function () {
    console.log('Hello Rana');
});

function log(message) {
    if (typeof (message) === 'object') {
        for (var item in message) {
            if (message.hasOwnProperty(item)) {
                util.log(util.colors.blue(message[item]));
            }
        }
    } else {
        util.log(util.colors.blue(message));
    }
}

