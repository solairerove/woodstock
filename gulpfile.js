var gulp           = require('gulp');
var mainBowerFiles = require('main-bower-files');
var inject         = require('gulp-inject');
var runSequence    = require('run-sequence');
var series         = require('stream-series');

var vendorJs;
var vendorCss;

gulp.task('lib-js-files', function () {
    vendorJs = gulp.src(mainBowerFiles('**/*.js'),{ base: 'bower_components' })
        .pipe(gulp.dest('src/main/resources/static/resources/vendor/js'));
});

gulp.task('lib-css-files', function () {
    vendorCss = gulp.src(mainBowerFiles('**/*.css'), {base: 'bower_components'})
        .pipe(gulp.dest('src/main/resources/static/resources/vendor/css'));
});

gulp.task('index', function () {
    var target = gulp.src("src/main/resources/static/index.html");
    var sources = gulp.src(['src/main/resources/static/app/**/*.js', 'src/main/resources/static/resources/css/**/*.css'], {read: false});
    return target.pipe(inject(series(vendorJs, vendorCss, sources), {relative: true}))
        .pipe(gulp.dest('src/main/resources/static/'));
});

gulp.task('build', function () {
    runSequence('lib-js-files', 'lib-css-files', 'index');
});
