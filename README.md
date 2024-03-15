<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

  <h1>OSGi Online Mall</h1>

  <p>Welcome to the OSGi Online Mall project repository! This project is developed as part of the Software Architecture module SE3030. The aim of this project is to demonstrate the application of OSGi (Open Service Gateway Initiative) framework in building a modular and extensible online shopping mall platform.</p>

  <h2>Overview</h2>
  <p>The OSGi Online Mall incorporates various stalls offering diverse services such as a cinema, restaurant, clothing store, and a salon. Each stall is represented as a modular component within the OSGi framework, allowing for independent development, deployment, and management.</p>

  <h2>Features</h2>
  <h3>Stalls and Services</h3>
  <ul>
    <li><strong>Cinema:</strong> Provides functionalities for managing movie listings, bookings, and promotions.</li>
    <li><strong>Restaurant:</strong> Offers services for menu management, table reservations, and promotions.</li>
    <li><strong>Clothing Store:</strong> Facilitates clothing rental, purchase, delivery, and promotions.</li>
    <li><strong>Salon:</strong> Manages salon appointments, services, and promotions.</li>
  </ul>

  <h3>Interconnected Publishers and Subscribers</h3>
  <ul>
    <li><strong>Common Subscriber:</strong> Maps all subscribers from the stalls within the mall.</li>
    <li><strong>Common Publisher:</strong> Publishes common services accessible to all stalls.</li>
    <li><strong>ClothingStoreCategoryPublisher:</strong> Publishes clothing store categories.</li>
    <li><strong>ClothingStoreCustomerSubscriber:</strong> Subscribes to clothing store customer interactions.</li>
    <li><strong>ClothingStoreDeliverPublisher:</strong> Publishes clothing store delivery updates.</li>
    <li><strong>ClothingStoreRentalPublisher:</strong> Publishes clothing rental details.</li>
    <li><strong>ClothingStorePromotionPublisher:</strong> Publishes clothing store promotions.</li>
    <li><strong>MovieAdminConsumer/Producer:</strong> Handles administrative tasks for movies.</li>
    <li><strong>MovieCustomerConsumer/Producer:</strong> Manages customer interactions with movies.</li>
    <li><strong>MovieItemsProducer:</strong> Produces movie-related items.</li>
    <li><strong>RestaurantAdminPublisher/Subscriber:</strong> Manages restaurant administrative tasks.</li>
    <li><strong>RestaurantPublisher/Subscriber:</strong> Handles restaurant services and interactions.</li>
    <li><strong>SaloonPublisher/Subscriber:</strong> Manages salon services and interactions.</li>
  </ul>

  <h3>Design Pattern</h3>
  <p>The publishers and subscribers for relevant shops are interconnected using the publisher-subscriber pattern, enabling efficient communication and data exchange between different components of the mall.</p>

  <h2>Contribution</h2>
  <p>Contributions to this project are welcomed! Please feel free to submit bug reports, feature requests, or pull requests.</p>

  <p>Thank you for visiting the OSGi Online Mall repository. Happy shopping! 🛍️🎬🍽️💇‍♀️</p>

![Diagram](https://github.com/SandunJay/OSGi-Online-mall/assets/99672222/c64fd110-5043-49d7-8042-975b682b1c45)


</body>
</html>
