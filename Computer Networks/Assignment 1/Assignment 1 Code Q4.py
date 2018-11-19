import csv
with open('dataAlpha.csv', 'r') as f:
  reader = csv.reader(f)
  alphaList = list(reader)
alphaList = alphaList[1:len(alphaList)]

with open('dataBravo.csv', 'r') as f:
  reader = csv.reader(f)
  bravoList = list(reader)
bravoList = bravoList[1:len(bravoList)]

lostAlpha = 0; lostBravo = 0;
sumAlphaRTT = 0; sumBravoRTT = 0;
for alpha in alphaList:
    if float(alpha[1]) == -1:
        lostAlpha+=1;
    else:
        sumAlphaRTT+=float(alpha[1]);
for bravo in bravoList:
    if float(bravo[1]) == -1:
        lostBravo+=1;
    else:
        sumBravoRTT+=float(alpha[1]);
averageAlphaRTT = sumAlphaRTT / (len(alphaList)-lostAlpha)
averageBravoRTT = sumBravoRTT / (len(bravoList)-lostBravo)

print("The Average RTT of Alpha is: "+str(averageAlphaRTT));
print("The Average RTT of Bravo is: "+str(averageBravoRTT));
print("The Lost Packets of alpha are: " + str(lostAlpha));
print("The Lost packets of bravo are: " + str(lostBravo));
