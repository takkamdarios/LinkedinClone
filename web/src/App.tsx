import React from 'react';
import { BrowserRouter as Router } from 'react-router-dom';

//import Footer from './components/Footer';
import Header from './components/header/Header';
import CustomRoutes from './Routes';

const App: React.FC = () => {
    return (
        <Router>
            {/*className="min-h-screen flex flex-col"*/}
            <div >
                <Header />
                <main >
                    {/*className="flex-grow container mx-auto px-4 py-6"*/}
                   <CustomRoutes/>
                </main>
                {/*<Footer />*/}
            </div>
        </Router>
    );
};

export default App;

