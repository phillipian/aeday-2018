var gulp = require('gulp');
var sass = require('gulp-sass');
var pug = require('gulp-pug');
var minify = require('gulp-minify');
var webserver = require('gulp-webserver');
var imagemin = require('gulp-imagemin');

gulp.task('default', ['webserver', 'sass', 'compressjs', 'imagemin', 'compresspug'], function() {
  gulp.watch('src/SCSS/*.scss', ['sass']);
  gulp.watch('src/views/*.pug', ['compresspug']);
  gulp.watch('src/views/**/*.pug', ['compresspug']);
  gulp.watch('src/JS/*.js', ['compressjs']);
  gulp.watch('src/images/*', ['imagemin']);
  gulp.watch('src/images/**/*', ['imagemin']);
});

gulp.task('compresspug', function buildHTML() {
  return gulp.src('src/views/*.pug')
    .pipe(pug())
    .pipe(gulp.dest('.'));
});

gulp.task('imagemin', function () {
  gulp.src('src/images/*')
    .pipe(imagemin())
    .pipe(gulp.dest('dist/images'));

  gulp.src('src/images/**/*')
    .pipe(imagemin())
    .pipe(gulp.dest('dist/images'));
});

gulp.task('sass', function () {
  return gulp.src('src/SCSS/*.scss')
    .pipe(sass({outputStyle: 'compressed'}).on('error', sass.logError))
    .pipe(gulp.dest('dist/CSS'));
});

gulp.task('compressjs', function() {
  gulp.src('src/JS/*.js')
    .pipe(minify({}))
    .pipe(gulp.dest('dist/JS'));
});

gulp.task('webserver', function() {
  gulp.src('./')
    .pipe(webserver({
      livereload: true,
      open: true
    }));
});
