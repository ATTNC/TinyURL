import { useState } from 'react';
import './App.css';
import './ExpireTime.css'
import ExpireTime from './ExpireTime';

function App() {
  const [url, setUrl] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Girilen URL:", url);
  };

  return (
    <div className="container">
      <form onSubmit={handleSubmit}>
        <input
          type="url"
          placeholder="Enter the URL you want to shorten"
          value={url}
          onChange={(e) => setUrl(e.target.value)}
          className="url-input"
          required
        />
        <ExpireTime />
        <button type="submit">Shorten</button>
      </form>
    </div>
  );
}

export default App;
