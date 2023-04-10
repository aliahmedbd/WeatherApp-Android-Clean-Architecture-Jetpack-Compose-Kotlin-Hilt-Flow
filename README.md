# WeatherApp-Android-Clean-Architecture-Jetpack-Compose-Kotlin-Hilt-Flow

The Clean Architecture is a software design pattern that separates the business logic from the presentation layer. This makes the application more modular and easier to test. Jetpack Compose is a modern toolkit for building native Android UIs. It is declarative and composable, making it easy to create complex UIs with less code. Kotlin is a modern programming language that is fully interoperable with Java. It is concise, expressive, and safe. Coroutines are a lightweight concurrency model that makes it easy to write asynchronous code. Flow is a reactive programming library that makes it easy to handle streams of data. Hilt is a dependency injection library that makes it easy to manage dependencies in Android applications. Unit Testing is a software testing technique that is used to verify the correctness of individual units of code.

This project is a good example of how to use modern Android technologies to build a high-quality application. It is well-designed, easy to test, and uses the latest tools and technologies.

### Screenshots

<img src="https://user-images.githubusercontent.com/11981999/230939471-a1da5444-ea34-4663-b396-1b7294c810b5.png" width="200" height="400">  <img src="https://user-images.githubusercontent.com/11981999/230939486-43d06415-90bc-4b96-9294-31be6b14aa3e.png" width="200" height="400">  <img src="https://user-images.githubusercontent.com/11981999/230939490-ff1d1772-8495-4e73-bbf0-0ba0b7985421.png" width="200" height="400">  <img src="https://user-images.githubusercontent.com/11981999/230939504-e8a81e28-082f-4fd6-857f-3097e3aea424.png" width="200" height="400">

### Features
- Get current weather data
- Get hourly forcasting
- Get 10 days weather forecast result


### Used Technologies

I tried to build this application following these terms. which are:

- performance
- readability
- maintainability
- testability
- scalability
- simplicity

The tools I have used to gain the Android Clean Architecture are:

- <b> Android Clean Architecture:</b> The Clean Architecture is a software design pattern that separates the business logic from the presentation layer. This makes the application more modular and easier to test.
- <b> MVVM :</b>  MVVM architecure is followed for the code boilerplate. Where View, ViewModel, Repisitory are clearly used for maintailed the SOLID principle. 
- <b> Kotlin :</b> Kotlin is a modern programming language that is fully interoperable with Java. It is concise, expressive, and safe.  (https://kotlinlang.org/)
- <b> Coroutine :</b> To reduce the main thread task we can divide the task in many thread asychronously using the Kotlin Coroutine using lifecycle scope. (https://developer.android.com/kotlin/coroutines)
- <b> Hilt :</b> Hilt is a dependency injection library that makes it easy to manage dependencies in Android applications.
- <b> Jetpack Compose Navigation : </b> Jetpack Compose Navigation is a declarative navigation library that makes it easy to navigate between different screens in your app. It is declarative, meaning that you can describe your navigation in terms of what you want to happen, rather than how you want it to happen. This makes it easy to create complex navigation flows with less code.
- <b> Kotlin Flow :</b> In coroutines, a flow is a type that can emit multiple values sequentially, as opposed to suspend functions that return only a single value. (https://developer.android.com/kotlin/flow)
- <b> Retrofit :</b> Network calling library (https://square.github.io/retrofit/)
- <b> Unit Testing:</b> Unit Testing is a software testing technique that is used to verify the correctness of individual units of code. I have used Junit4 anc Mockk for the unit testing purspose.



#### API Specification
For this repository I have used a public weather api. Weather Data: structured, relevant, real-time Search multi-language worldwide weather report. Real Time, Forecasted, Future, Marine and Historical Weather, Here is the link: (https://www.weatherapi.com/)

