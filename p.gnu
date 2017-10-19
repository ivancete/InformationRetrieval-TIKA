#!/usr/bin/env gnuplot


#Fichero Gutenberg.html

set xlabel "Terms"

set ylabel "frequency of terms"

set key box linestyle 1 lt rgb "orange"

set autoscale xy

set xtics rotate # crucial line

plot 'datosSalida/Gutenberg-Ocurrences.dat' using 1:2 title "NumberOccurrences" with linespoints

set terminal svg

set output "Images/Gutenberg-occurrences-frequency.svg"

replot

set terminal png

set output "Images/Gutenberg-occurrences-frequency.png"

replot

plot 'datosSalida/Gutenberg-OcurrencesLog.dat' using 1:2 title "NumberOccurrencesLog" with linespoints

set terminal svg

set output "Images/Gutenberg-occurrences-frequency-LogLog.svg"

replot

set terminal png

set output "Images/Gutenberg-occurrences-frequency-LogLog.png"

replot

f(x)=a*x+b

fit f(x) 'datosSalida/Gutenberg-OcurrencesLog.dat' via a,b

plot 'datosSalida/Gutenberg-OcurrencesLog.dat' title "NumberOccurrencesLogFitting" with linespoints, f(x) 

set terminal svg

set output "Images/Gutenberg-occurrences-frequency-fitting-LogLog.svg"

replot

set terminal png

set output "Images/Gutenberg-occurrences-frequency-fitting-LogLog.png"

replot

#Fichero Szerelem bolondjai________________________________________________________________________________________________________

set xlabel "Terms"

set ylabel "frequency of terms"

set autoscale xy

plot 'datosSalida/Szerelem bolondjai-Ocurrences.dat' using 1:2 title "NumberOccurrences" with linespoints

set terminal svg

set output "Images/occurrences-frequency-Szerelem bolondjai.svg"

replot

set terminal png

set output "Images/occurrences-frequency-Szerelem bolondjai.png"

replot

#Fichero Szerelem bolondjai LOG________________________________________________________________________________________________________


plot 'datosSalida/Szerelem bolondjai-OcurrencesLog.dat' using 1:2 title "NumberOccurrencesLog" with linespoints

set terminal svg

set output "Images/occurrences-frequency-Szerelem bolondjai-LogLog.svg"

replot

set terminal png

set output "Images/occurrences-frequency-Szerelem bolondjai-LogLog.png"

replot

#Fichero Szerelem bolondjai LOG LINEAR__________________________________________________________________________________________________

f(x)=a*x+b

fit f(x) 'datosSalida/Szerelem bolondjai-OcurrencesLog.dat' via a,b

plot 'datosSalida/Szerelem bolondjai-OcurrencesLog.dat' title "NumberOccurrencesLogFitting" with linespoints, f(x) 

set terminal svg

set output "Images/occurrences-frequency-Szerelem bolondjai-fitting-LogLog.svg"

replot

set terminal png

set output "Images/occurrences-frequency-Szerelem bolondjai-fitting-LogLog.png"

replot

#Fichero Cartas para mi molino________________________________________________________________________________________________________

set xlabel "Terms"

set ylabel "frequency of terms"

set autoscale xy

plot 'datosSalida/Cartas de mi molino-Ocurrences.dat' using 1:2 title "NumberOccurrences" with linespoints

set terminal svg

set output "Images/occurrences-frequency-Cartas-molino.svg"

replot

set terminal png

set output "Images/occurrences-frequency-Cartas-molino.png"

replot

#Fichero Cartas para mi molino LOG________________________________________________________________________________________________________


plot 'datosSalida/Cartas de mi molino-OcurrencesLog.dat' using 1:2 title "NumberOccurrencesLog" with linespoints

set terminal svg

set output "Images/occurrences-frequency-Cartas-molino-LogLog.svg"

replot

set terminal png

set output "Images/occurrences-frequency-Cartas-molino-LogLog.png"

replot

#Fichero Cartas para mi molino LOG LINEAR__________________________________________________________________________________________________


f(x)=a*x+b

fit f(x) 'datosSalida/Cartas de mi molino-OcurrencesLog.dat' via a,b

plot 'datosSalida/Cartas de mi molino-OcurrencesLog.dat' title "NumberOccurrencesLogFitting" with linespoints, f(x) 

set terminal svg

set output "Images/occurrences-frequency-Cartas-molino-fitting-LogLog.svg"

replot

set terminal png

set output "Images/occurrences-frequency-Cartas-molino-fitting-LogLog.png"

replot

#Fichero History of Cleopatra, Queen of Egypt_______________________________________________________________________________________________

set xlabel "Terms"

set ylabel "frequency of terms"

set autoscale xy

plot 'datosSalida/History of Cleopatra, Queen of Egypt-Ocurrences.dat' using 1:2 title "NumberOccurrences" with linespoints

set terminal svg

set output "Images/occurrences-frequency-History-Cleopatra.svg"

replot

set terminal png

set output "Images/occurrences-frequency-History-Cleopatra.png"

replot

#Fichero History of Cleopatra, Queen of Egypt LOG___________________________________________________________________________________________


plot 'datosSalida/History of Cleopatra, Queen of Egypt-OcurrencesLog.dat' using 1:2 title "NumberOccurrencesLog" with linespoints

set terminal svg

set output "Images/occurrences-frequency-History-Cleopatra-LogLog.svg"

replot

set terminal png

set output "Images/occurrences-frequency-History-Cleopatra-LogLog.png"

replot

#Fichero History of Cleopatra, Queen of Egypt LOG LINEAR_____________________________________________________________________________________


f(x)=a*x+b

fit f(x) 'datosSalida/History of Cleopatra, Queen of Egypt-OcurrencesLog.dat' via a,b

plot 'datosSalida/History of Cleopatra, Queen of Egypt-OcurrencesLog.dat' title "NumberOccurrencesLogFitting" with linespoints, f(x) 

set terminal svg

set output "Images/occurrences-frequency-History-Cleopatra-fitting-LogLog.svg"

replot

set terminal png

set output "Images/occurrences-frequency-History-Cleopatra-fitting-LogLog.png"

replot

#FIN----------------------------------------------------------------------------------------------------------------------------------------