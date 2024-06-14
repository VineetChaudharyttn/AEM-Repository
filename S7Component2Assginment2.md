Question 2: How many requests are made when you embed a clientLib which itself has one dependency?

Answer: When we are going to embed a new clientLib it will add one requests, but it the case of dependency it has two case.
The one is that dependency request is already exist, in such case there will be no extra call added due to the new clientLib. In the seconed case where we are not having call for the dependency, a dependency request will be added.
