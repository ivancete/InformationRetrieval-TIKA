#!/usr/bin/env gnuplot

set xlabel "Terms"

set ylabel "frequency of terms"

set key box linestyle 1 lt rgb "orange"

set autoscale xy

set lmargin 10

set xtics rotate # crucial line

plot 'Gutenberg-Ocurrences.txt' every ::::50 using 1:xtic(2) title "NumberOccurrences" with linespoints

set terminal svg

set output "Images/occurrences-frequency.svg"

replot

set terminal png

set output "Images/occurrences-frequency.png"

replot