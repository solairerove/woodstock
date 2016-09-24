var gulp           = require('gulp');
var mainBowerFiles = require('main-bower-files');
var inject         = require('gulp-inject');
var runSequence    = require('run-sequence');
var series         = require('stream-series');

var vendorJs;
var vendorCss;

gulp.task('lib-js-files', function () {
    vendorJs = gulp.src(mainBowerFiles('**/*.js'),{ base: 'bower_components' })
        .pipe(gulp.dest('src/main/webapp/resources/vendor/js'));
});

gulp.task('lib-css-files', function () {
    vendorCss = gulp.src(mainBowerFiles('**/*.css'), {base: 'bower_components'})
        .pipe(gulp.dest('src/main/webapp/resources/vendor/css'));
});

gulp.task('index', function () {
    var target = gulp.src("src/main/webapp/index.html");
    var sources = gulp.src(['src/main/webapp/app/**/*.js', 'src/main/webapp/resources/css/**/*.css'], {read: false});
    return target.pipe(inject(series(vendorJs, vendorCss, sources), {relative: true}))
        .pipe(gulp.dest('src/main/webapp'));
});

gulp.task('build', function () {
    runSequence('lib-js-files', 'lib-css-files', 'index');
});
