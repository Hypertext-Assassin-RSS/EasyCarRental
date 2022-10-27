import { useRef } from "react";
import { FaBars, FaTimes } from "react-icons/fa";
import "../Navbar/Navbar.css";

function Navbar() {
	const navRef = useRef();

	const showNavbar = () => {
		navRef.current.classList.toggle("responsive_nav");
	};

	return (
		<header>
			 <h3>EASY CAR RENTAL {/*<img className="logo" src="https://static.vecteezy.com/system/resources/previews/005/972/810/large_2x/car-and-key-rental-icon-vector.jpg"/>  */}</h3>
			<nav ref={navRef}>
				<a href="/home">Home</a>
				<a href="/catlog">Catlog</a>
				<a href="/Login">Login/Register</a>
				<button
					className="nav-btn nav-close-btn"
					onClick={showNavbar}>
					<FaTimes />
				</button>
			</nav>
			<button className="nav-btn" onClick={showNavbar}>
				<FaBars />
			</button>
		</header>
	);
}

export default Navbar;
