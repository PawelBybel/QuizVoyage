// import config from '.././config'

export default class View{
    _data;
    
    render(data){
        // if(!data || (Array.isArray(data) && data.length === 0)) return this.renderError();
        if (!this._parentElement) return;
        
          this._data = data;
          const markup = this._generateMarkupPreview(data);
          this._clear();
          this._parentElement.insertAdjacentHTML('afterbegin',markup);
      }
      _clear(){
        this._parentElement.innerHTML = '';
    }
}