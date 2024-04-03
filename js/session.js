class Session {
    constructor() {
      this.userSession = null;
    }
  
    createSession(user) {
      // Tworzenie nowej sesji
      this.userSession = user;
    }
  
    saveSession() {
      // Zapisanie danych sesji
      // Możesz użyć localStorage lub sessionStorage, aby zapisać sesję w przeglądarce
    }
  
    loadSession() {
      // Odczytanie danych sesji
      // Możesz użyć localStorage lub sessionStorage, aby odczytać sesję z przeglądarki
    }
  
    deleteSession() {
      // Usunięcie sesji
      this.userSession = null;
      // Możesz również usunąć sesję z localStorage lub sessionStorage
    }
  
    getSession() {
      // Pobranie danych sesji
      return this.userSession;
    }
  }
  
  export default new Session();