import logo from './logo.svg';
import './App.css';

function App() {

  function PoleSzescian(a) {
    return a^3;
  }

  function ObjetoscSzescian(a) {
    return 6*a^2;
  }

  function PoleProstopadloscian(a, b, h) {
    return 2 * a * b + 2 * a * h + 2 * b * h;
  }

  function ObjetoscProstopadloscian(a, b, h) {
    return a * b * h;
  }

  function PoleKolo(r) {
    return 4 * 3,14 * r^2;
  }

  function ObjetoscKolo(r) {
    return 4/3 * 3,14 * r^3;
  }

  const wzory = [
    {"id":0,
      "bryla":"sześcian",
      "ilustracja":"img",
      "wzorObjetosc":"V = a^3",
      "wzorPole":"P = 6a^2",
      "wymiar": [
        {"id": 1, "w":2}
      ],
      "przyklad":[
        {"id":"pole", "wynnik": 24},
        {"id":"objetosc", "wynik": 8},
      ]
    },
    {"id":1,
      "bryla":"prostopadłóścian",
      "ilustracja":"img",
      "wzor":[
        {"id":"objetosc", "wzor": "V = a * b * h"},
        {"id":"pole", "wzor": "P = 2 * a * b + 2 * a * h + 2 * b * h"}
      ],
      "wymiar":[
        {"id": 1, "w":3},
        {"id": 2, "w":4},
        {"id": 3, "w":5}
      ],
      "przyklad":[
        {"id":"pole", "wynnik": 94},
        {"id":"objetosc", "wynik": 60},
      ]
    },
    {"id":2,
      "bryla":"kolo",
      "ilustracja":"img",
      "wzor":[
        {"id":"objetosc", "wzor": "V = 4/3 * pi * r^3"},
        {"id":"pole", "wzor": "P = 4 * pi * r^2"}
      ],
      "wymiar":[
        {"id": 1, "w":4},
      ],
      "przyklad":[
        {"id":"pole", "wynnik": 200.96},
        {"id":"objetosc", "wynik": 267.94666666666666},
      ]
    }
  ]

  const wynikPola = 0;
  const wynikObjetosci = 0;
  const wymiary = [];
  return (
    <div className='App'>
      <h1>Bryly</h1>

      <table>
        <thead>
          <tr>
            <th><h2>BRYŁA</h2></th>
            <th><h2>ILUSTRACJA</h2></th>
            <th><h2>WZORY</h2></th>
            <th><h2>PRZYKŁAD</h2></th>
          </tr>
        </thead>

        <tbody>
          {wzory.map((item, index)=>(
              <tr key={index}>
                <td><h3>{item.bryla}</h3></td>
                <td>{item.ilustracja}</td>
                <td>Objętość: {item.wzorObjetosc}<br/> Pole: {item.wzorPole}</td>
                <td>
                  <ol>
                    {wymiary = item.wymiar[2]}
                    {item.wymiar.map((itemW, indexW)=>(
                      <li key={itemW.id}>Wymiar" {itemW.w}</li>
                    ))}
                  </ol>
                  <div className='wynik'>
                    {item.bryla === 'sześcian' ?? (wynikPola = PoleSzescian(wymiary[0]))}
                    {item.bryla === 'prostopadłóścian' ?? (wynikPola = PoleProstopadloscian(wymiary[0], wymiary[1], wymiary[2]))}
                    {item.bryla === 'kolo' ?? (wynikPola = PoleKolo(wymiary[0]))}
                    POLE: {wynikPola} <br/>
                    OBJĘTOŚĆ: {wynikObjetosci}
                  </div>
                </td>
              </tr>
          ))}

          {/* <tr>
            <td><h3>SZEŚCIAN</h3></td>
            <td>Img</td>
            <td>Objętość: V = a^3 <br/> Pole: P = 6a^2</td>
            <td>
              <p>1. wymiar: 2</p>
              <div className='wynik'>
                POLE: 24 <br/>
                OBJĘTOŚĆ: 8
              </div>
            </td>
          </tr>

          <tr>
            <td><h3>PROSTOPADŁOŚCIAN</h3></td>
            <td>Img</td>
            <td>Objętość: V = a * b * h <br/> Pole: P = 2 * a * b + 2 * a * h + 2 * b * h</td>
            <td>
              <p>
                1. wymiar: 3 <br />
                2. wymiar: 4 <br />
                3. wymiar: 5 <br />
              </p>
              
              <div className='wynik'>
                POLE: 94 <br/>
                OBJĘTOŚĆ: 60
              </div>
            </td>
          </tr>

          <tr>
            <td><h3>KOŁO</h3></td>
            <td>Img</td>
            <td>Objętość: V = 4/3 * pi * r^3 <br/> Pole: P = 4 * pi * r^2</td>
            <td>
              <p>1. wymiar: 4</p>
              <div className='wynik'>
                POLE: 200.96 <br/>
                OBJĘTOŚĆ: 267.94666666666666
              </div>
            </td>
          </tr> */}
        </tbody>
      </table>
    </div>
  );
}

export default App;
