This is a examproject build with a React frontend and a Spring backend. <br>
The frontend can be viewed at (but needs to be self hosted to get the backend working): 
https://tobiasheidlund.github.io/Exam-cicd/
<br>Planning figma: https://www.figma.com/board/31LpmoFjdF1dsxDJibcnFm/Untitled?node-id=1-386&t=7KAisJYgAH9BoNHK-1

Steps to get it working:<br>
(Prebuilt this will run on port 8080)
```
1. Download the latest release the releases tab,
2. Start it with java.exe -jar "Filename"
```
  
(Self Built)
```
1. Clone the Backend-Main
2. Build it with maven using "mvn install"
3. Start it using java.exe -jar "Filename"
```
(Frontend)
```
1. Clone it from the main branch
2. Setup react & vite using npm install
3. If the port was changed on the backend this can also be changed in the .env file
4. Start it by using "npm run dev"
```
