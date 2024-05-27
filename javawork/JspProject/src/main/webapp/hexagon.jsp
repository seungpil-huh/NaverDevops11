<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hexagon Grid</title>
    <style>
        @charset "UTF-8";
:root {
  --color-primary: #ee75d2;
  --color-secondary: #75d8ee;
  --color-tertiary: #deee75;
  --color-quaternary: #9375ee;
  --color-surface: black;
  --bg: linear-gradient(
    to bottom,
    color-mix(in srgb, var(--color-quaternary), black 70%),
    var(--color-surface)
  );
  --color-on-surface: var(--color-primary);
  --hover-filter: brightness(1.2);
}
@media (any-pointer: fine) {
  :root {
    --icon-filter: saturate(3.4) brightness(0.5) invert(1);
    --ripple-filter: blur(1rem);
  }
}

.vision-ui {
  --color-surface-container: rgba(255, 255, 255, 0.35);
  --color-on-surface: white;
  --hover-filter: brightness(1.5);
}
@media (any-pointer: fine) {
  .vision-ui {
    --icon-filter: saturate(0.4);
    --ripple-filter: filter(0.2rem);
  }
}

@property --index {
  syntax: "<number>";
  initial-value: 0;
  inherits: true;
}
@property --ripple-factor {
  syntax: "<number>";
  initial-value: 0;
  inherits: true;
}
:root {
  --hexagon-size: 8vmin;
  --gap: 0.1vmin;
}

.container {
  display: flex;
  position: relative;
  align-items: center;
}
.container .column {
  margin: 0 -0.2vmin;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.hexagon {
  --mix-percentage: calc(var(--column) * var(--index) * 3%);
  width: var(--hexagon-size);
  aspect-ratio: 1;
  position: relative;
  background: var(--color-surface-container, color-mix(in srgb, var(--color-secondary), var(--color-primary) var(--mix-percentage)));
  -webkit-backdrop-filter: blur(1rem);
          backdrop-filter: blur(1rem);
  -webkit-clip-path: polygon(98.66024% 45%, 99.39693% 46.5798%, 99.84808% 48.26352%, 100% 50%, 99.84808% 51.73648%, 99.39693% 53.4202%, 98.66025% 55%, 78.66025% 89.64102%, 77.66044% 91.06889%, 76.42788% 92.30146%, 75% 93.30127%, 73.4202% 94.03794%, 71.73648% 94.48909%, 70% 94.64102%, 30% 94.64102%, 28.26352% 94.48909%, 26.5798% 94.03794%, 25% 93.30127%, 23.57212% 92.30146%, 22.33956% 91.06889%, 21.33975% 89.64102%, 1.33975% 55%, 0.60307% 53.4202%, 0.15192% 51.73648%, 0% 50%, 0.15192% 48.26352%, 0.60307% 46.5798%, 1.33975% 45%, 21.33975% 10.35898%, 22.33956% 8.93111%, 23.57212% 7.69854%, 25% 6.69873%, 26.5798% 5.96206%, 28.26352% 5.51091%, 30% 5.35898%, 70% 5.35898%, 71.73648% 5.51091%, 73.4202% 5.96206%, 75% 6.69873%, 76.42788% 7.69854%, 77.66044% 8.93111%, 78.66025% 10.35898%);
          clip-path: polygon(98.66024% 45%, 99.39693% 46.5798%, 99.84808% 48.26352%, 100% 50%, 99.84808% 51.73648%, 99.39693% 53.4202%, 98.66025% 55%, 78.66025% 89.64102%, 77.66044% 91.06889%, 76.42788% 92.30146%, 75% 93.30127%, 73.4202% 94.03794%, 71.73648% 94.48909%, 70% 94.64102%, 30% 94.64102%, 28.26352% 94.48909%, 26.5798% 94.03794%, 25% 93.30127%, 23.57212% 92.30146%, 22.33956% 91.06889%, 21.33975% 89.64102%, 1.33975% 55%, 0.60307% 53.4202%, 0.15192% 51.73648%, 0% 50%, 0.15192% 48.26352%, 0.60307% 46.5798%, 1.33975% 45%, 21.33975% 10.35898%, 22.33956% 8.93111%, 23.57212% 7.69854%, 25% 6.69873%, 26.5798% 5.96206%, 28.26352% 5.51091%, 30% 5.35898%, 70% 5.35898%, 71.73648% 5.51091%, 73.4202% 5.96206%, 75% 6.69873%, 76.42788% 7.69854%, 77.66044% 8.93111%, 78.66025% 10.35898%);
  cursor: pointer;
}
@media (hover) {
  .hexagon:hover {
    filter: var(--hover-filter);
  }
}
.hexagon:after {
  content: var(--icon);
  display: grid;
  place-items: center;
  position: absolute;
  filter: var(--icon-filter);
  font-size: 2.5vmin;
  inset: 0;
}

@-webkit-keyframes ripple {
  from {
    transform: scale(1);
    opacity: 1;
  }
  50% {
    transform: scale(max(0.8, calc(var(--ripple-factor) / 100)));
    opacity: 0.42;
  }
  65% {
    opacity: 1;
  }
  70% {
    transform: scale(1.5);
    filter: var(--ripple-filter);
  }
  to {
    transform: scale(1);
    opacity: 1;
  }
}

@keyframes ripple {
  from {
    transform: scale(1);
    opacity: 1;
  }
  50% {
    transform: scale(max(0.8, calc(var(--ripple-factor) / 100)));
    opacity: 0.42;
  }
  65% {
    opacity: 1;
  }
  70% {
    transform: scale(1.5);
    filter: var(--ripple-filter);
  }
  to {
    transform: scale(1);
    opacity: 1;
  }
}
.container.show-ripple {
  pointer-events: none;
}
.container.show-ripple .hexagon {
  cursor: default;
  --duration: 0.45s;
  -webkit-animation: ripple var(--duration) ease-in-out;
          animation: ripple var(--duration) ease-in-out;
  -webkit-animation-duration: max(var(--duration), calc(var(--duration) * var(--ripple-factor) / 100));
          animation-duration: max(var(--duration), calc(var(--duration) * var(--ripple-factor) / 100));
  -webkit-animation-delay: calc(var(--ripple-factor) * 8ms);
          animation-delay: calc(var(--ripple-factor) * 8ms);
}

.switch {
  --mix-percentage: calc(var(--column) * var(--index) * 3%);
  width: var(--hexagon-size);
  aspect-ratio: 1;
  position: relative;
  background: var(--color-surface-container, color-mix(in srgb, var(--color-secondary), var(--color-primary) var(--mix-percentage)));
  -webkit-backdrop-filter: blur(1rem);
          backdrop-filter: blur(1rem);
  -webkit-clip-path: polygon(98.66024% 45%, 99.39693% 46.5798%, 99.84808% 48.26352%, 100% 50%, 99.84808% 51.73648%, 99.39693% 53.4202%, 98.66025% 55%, 78.66025% 89.64102%, 77.66044% 91.06889%, 76.42788% 92.30146%, 75% 93.30127%, 73.4202% 94.03794%, 71.73648% 94.48909%, 70% 94.64102%, 30% 94.64102%, 28.26352% 94.48909%, 26.5798% 94.03794%, 25% 93.30127%, 23.57212% 92.30146%, 22.33956% 91.06889%, 21.33975% 89.64102%, 1.33975% 55%, 0.60307% 53.4202%, 0.15192% 51.73648%, 0% 50%, 0.15192% 48.26352%, 0.60307% 46.5798%, 1.33975% 45%, 21.33975% 10.35898%, 22.33956% 8.93111%, 23.57212% 7.69854%, 25% 6.69873%, 26.5798% 5.96206%, 28.26352% 5.51091%, 30% 5.35898%, 70% 5.35898%, 71.73648% 5.51091%, 73.4202% 5.96206%, 75% 6.69873%, 76.42788% 7.69854%, 77.66044% 8.93111%, 78.66025% 10.35898%);
          clip-path: polygon(98.66024% 45%, 99.39693% 46.5798%, 99.84808% 48.26352%, 100% 50%, 99.84808% 51.73648%, 99.39693% 53.4202%, 98.66025% 55%, 78.66025% 89.64102%, 77.66044% 91.06889%, 76.42788% 92.30146%, 75% 93.30127%, 73.4202% 94.03794%, 71.73648% 94.48909%, 70% 94.64102%, 30% 94.64102%, 28.26352% 94.48909%, 26.5798% 94.03794%, 25% 93.30127%, 23.57212% 92.30146%, 22.33956% 91.06889%, 21.33975% 89.64102%, 1.33975% 55%, 0.60307% 53.4202%, 0.15192% 51.73648%, 0% 50%, 0.15192% 48.26352%, 0.60307% 46.5798%, 1.33975% 45%, 21.33975% 10.35898%, 22.33956% 8.93111%, 23.57212% 7.69854%, 25% 6.69873%, 26.5798% 5.96206%, 28.26352% 5.51091%, 30% 5.35898%, 70% 5.35898%, 71.73648% 5.51091%, 73.4202% 5.96206%, 75% 6.69873%, 76.42788% 7.69854%, 77.66044% 8.93111%, 78.66025% 10.35898%);
  cursor: pointer;
  --index: 6;
  --column: 2;
  position: absolute;
  display: flex;
  top: 4vmin;
  right: 4vmin;
  width: 8vmin;
  height: 4vmin;
  cursor: pointer;
  font-size: 2vmin;
}
.switch:after {
  --mix-percentage: calc(var(--column) * var(--index) * 3%);
  width: var(--hexagon-size);
  aspect-ratio: 1;
  position: relative;
  background: var(--color-surface-container, color-mix(in srgb, var(--color-secondary), var(--color-primary) var(--mix-percentage)));
  -webkit-backdrop-filter: blur(1rem);
          backdrop-filter: blur(1rem);
  -webkit-clip-path: polygon(98.66024% 45%, 99.39693% 46.5798%, 99.84808% 48.26352%, 100% 50%, 99.84808% 51.73648%, 99.39693% 53.4202%, 98.66025% 55%, 78.66025% 89.64102%, 77.66044% 91.06889%, 76.42788% 92.30146%, 75% 93.30127%, 73.4202% 94.03794%, 71.73648% 94.48909%, 70% 94.64102%, 30% 94.64102%, 28.26352% 94.48909%, 26.5798% 94.03794%, 25% 93.30127%, 23.57212% 92.30146%, 22.33956% 91.06889%, 21.33975% 89.64102%, 1.33975% 55%, 0.60307% 53.4202%, 0.15192% 51.73648%, 0% 50%, 0.15192% 48.26352%, 0.60307% 46.5798%, 1.33975% 45%, 21.33975% 10.35898%, 22.33956% 8.93111%, 23.57212% 7.69854%, 25% 6.69873%, 26.5798% 5.96206%, 28.26352% 5.51091%, 30% 5.35898%, 70% 5.35898%, 71.73648% 5.51091%, 73.4202% 5.96206%, 75% 6.69873%, 76.42788% 7.69854%, 77.66044% 8.93111%, 78.66025% 10.35898%);
          clip-path: polygon(98.66024% 45%, 99.39693% 46.5798%, 99.84808% 48.26352%, 100% 50%, 99.84808% 51.73648%, 99.39693% 53.4202%, 98.66025% 55%, 78.66025% 89.64102%, 77.66044% 91.06889%, 76.42788% 92.30146%, 75% 93.30127%, 73.4202% 94.03794%, 71.73648% 94.48909%, 70% 94.64102%, 30% 94.64102%, 28.26352% 94.48909%, 26.5798% 94.03794%, 25% 93.30127%, 23.57212% 92.30146%, 22.33956% 91.06889%, 21.33975% 89.64102%, 1.33975% 55%, 0.60307% 53.4202%, 0.15192% 51.73648%, 0% 50%, 0.15192% 48.26352%, 0.60307% 46.5798%, 1.33975% 45%, 21.33975% 10.35898%, 22.33956% 8.93111%, 23.57212% 7.69854%, 25% 6.69873%, 26.5798% 5.96206%, 28.26352% 5.51091%, 30% 5.35898%, 70% 5.35898%, 71.73648% 5.51091%, 73.4202% 5.96206%, 75% 6.69873%, 76.42788% 7.69854%, 77.66044% 8.93111%, 78.66025% 10.35898%);
  display: grid;
  place-items: center;
  --index: 6;
  --column: 4;
  content: "👾";
  position: absolute;
  left: 0;
  top: 0;
  height: 4vmin;
  width: 6vmin;
  transition: transform 0.3s ease;
}
.switch.checked:after {
  transform: translateX(2vmin);
  content: "🕶️";
}

body {
  width: 100vw;
  height: 100vh;
  display: grid;
  place-items: center;
  background: var(--bg);
  color: var(--color-on-surface);
  overflow: hidden;
}
body:before {
  content: "";
  position: absolute;
  inset: 0;
  pointer-events: none;
  background: radial-gradient(at center, transparent 80%, black), linear-gradient(to top, rgba(0, 0, 0, 0.3) 70%, transparent), url(https://assets.codepen.io/907471/vision-pro-palm.jpg) no-repeat 45% center/cover;
  opacity: 0;
  filter: blur(0.5rem);
  transition: opacity 0.6s ease-in-out, filter 0.6s ease-in-out;
}

.vision-ui body:before {
  opacity: 1;
  filter: blur(0);
}

* {
  box-sizing: border-box;
}

a.labs-follow-me {
  display: flex;
  align-items: flex-end;
  justify-content: center;
  left: 2rem;
  right: 2rem;
  bottom: 0.5vh;
  top: unset;
  text-align: center;
}
a.labs-follow-me svg {
  width: 10vmin;
}
    </style>
</head>
<body>

<div class="container" id="container">
  <div class="column" style="--column: 0">
    <div class="hexagon" style="--index: 1; --icon: '🚀';"></div>
    <div class="hexagon" style="--index: 2; --icon: '🎸';"></div>
    <div class="hexagon" style="--index: 3; --icon: '🤖';"></div>
    <div class="hexagon" style="--index: 4; --icon: '🫶';"></div>
    <div class="hexagon" style="--index: 5; --icon: '🔥';"></div>
  </div>
  <div class="column" style="--column: 1">
    <div class="hexagon" style="--index: 1; --icon: '🕹️';"></div>
    <div class="hexagon" style="--index: 2; --icon: '👾';"></div>
    <div class="hexagon" style="--index: 3; --icon: '✨';"></div>
    <div class="hexagon" style="--index: 4; --icon: '🌴';"></div>
    <div class="hexagon" style="--index: 5; --icon: '🖥️';"></div>
    <div class="hexagon" style="--index: 6; --icon: '💻';"></div>
  </div>
  <div class="column" style="--column: 2">
    <div class="hexagon" style="--index: 1; --icon: '⌨️';"></div>
    <div class="hexagon" style="--index: 2; --icon: '💡';"></div>
    <div class="hexagon" style="--index: 3; --icon: '🕶️';"></div>
    <div class="hexagon" style="--index: 4; --icon: '⚙️';"></div>
    <div class="hexagon" style="--index: 5; --icon: '🍒';"></div>
    <div class="hexagon" style="--index: 6; --icon: '🧙‍♂️';"></div>
    <div class="hexagon" style="--index: 7; --icon: '🎮';"></div>
  </div>
  <div class="column" style="--column: 3">
    <div class="hexagon" style="--index: 1; --icon: '👽';"></div>
    <div class="hexagon" style="--index: 2; --icon: '🌌';"></div>
    <div class="hexagon" style="--index: 3; --icon: '🎧';"></div>
    <div class="hexagon" style="--index: 4; --icon: '🌒';"></div>
    <div class="hexagon" style="--index: 5; --icon: '🌓';"></div>
    <div class="hexagon" style="--index: 6; --icon: '🌔';"></div>
    <div class="hexagon" style="--index: 7; --icon: '🎵';"></div>
    <div class="hexagon" style="--index: 8; --icon: '🎶';"></div>
  </div>
  <div class="column" style="--column: 4">
    <div class="hexagon" style="--index: 1; --icon: '❤️';"></div>
    <div class="hexagon" style="--index: 2; --icon: '🎙️';"></div>
    <div class="hexagon" style="--index: 3; --icon: '📸';"></div>
    <div class="hexagon" style="--index: 4; --icon: '🕰️';"></div>
    <div class="hexagon" style="--index: 5; --icon: '🚀';"></div>
    <div class="hexagon" style="--index: 6; --icon: '🎸';"></div>
    <div class="hexagon" style="--index: 7; --icon: '🤖';"></div>
    <div class="hexagon" style="--index: 8; --icon: '🫶';"></div>
    <div class="hexagon" style="--index: 9; --icon: '🔥';"></div>
  </div>
  <div class="column" style="--column: 5">
    <div class="hexagon" style="--index: 1; --icon: '🕹️';"></div>
    <div class="hexagon" style="--index: 2; --icon: '👾';"></div>
    <div class="hexagon" style="--index: 3; --icon: '✨';"></div>
    <div class="hexagon" style="--index: 4; --icon: '🌴';"></div>
    <div class="hexagon" style="--index: 5; --icon: '🖥️';"></div>
    <div class="hexagon" style="--index: 6; --icon: '💻';"></div>
    <div class="hexagon" style="--index: 7; --icon: '⌨️';"></div>
    <div class="hexagon" style="--index: 8; --icon: '💡';"></div>
  </div>
  <div class="column" style="--column: 6">
    <div class="hexagon" style="--index: 1; --icon: '🕶️';"></div>
    <div class="hexagon" style="--index: 2; --icon: '⚙️';"></div>
    <div class="hexagon" style="--index: 3; --icon: '🍒';"></div>
    <div class="hexagon" style="--index: 4; --icon: '🦄';"></div>
    <div class="hexagon" style="--index: 5; --icon: '📱';"></div>
    <div class="hexagon" style="--index: 6; --icon: '🖨️';"></div>
    <div class="hexagon" style="--index: 7; --icon: '📡';"></div>
  </div>
  <div class="column" style="--column: 7">
    <div class="hexagon" style="--index: 1; --icon: '🔬';"></div>
    <div class="hexagon" style="--index: 2; --icon: '🔭';"></div>
    <div class="hexagon" style="--index: 3; --icon: '🎚️';"></div>
    <div class="hexagon" style="--index: 4; --icon: '🎛️';"></div>
    <div class="hexagon" style="--index: 5; --icon: '🧬';"></div>
    <div class="hexagon" style="--index: 6; --icon: '🔮';"></div>
  </div>
  <div class="column" style="--column: 8">
    <div class="hexagon" style="--index: 1; --icon: '🧲';"></div>
    <div class="hexagon" style="--index: 2; --icon: '🛸';"></div>
    <div class="hexagon" style="--index: 3; --icon: '🪐';"></div>
    <div class="hexagon" style="--index: 4; --icon: '🌠';"></div>
    <div class="hexagon" style="--index: 5; --icon: '👓';"></div>
  </div>
</div>
<div class="switch" id="switch"></div>

<script>
(() => {
	  const container = document.getElementById("container");

	  const hexagons = container.querySelectorAll(".hexagon");
	  const hexagonElements = new Array(...hexagons);

	  const ripple = (target) => {
	    if (container.classList.contains("show-ripple")) {
	      return;
	    }
	    const targetRect = target.getBoundingClientRect();
	    const data = hexagonElements
	      .map((element) => {
	        const rect = element.getBoundingClientRect();
	        const centerX = rect.x + rect.width / 2;
	        const centerY = rect.y + rect.height / 2;
	        const distance = Math.round(
	          Math.sqrt(
	            Math.pow(rect.x - targetRect.x, 2) +
	              Math.pow(rect.y - targetRect.y, 2)
	          )
	        );
	        return { element, rect, centerX, centerY, distance };
	      })
	      .sort((a, b) =>
	        a.distance > b.distance ? 1 : a.distance < b.distance ? -1 : 0
	      );

	    const [max] = data.slice(-1);
	    data.forEach((item) =>
	      item.element.style.setProperty(
	        "--ripple-factor",
	        `${(item.distance * 100) / max.distance}`
	      )
	    );
	    container.classList.toggle("show-ripple");
	    const cleanUp = () => {
	      requestAnimationFrame(() => {
	        container.classList.remove("show-ripple");
	        data.forEach((item) =>
	          item.element.style.removeProperty("--ripple-factor")
	        );
	        max.element.removeEventListener("animationend", cleanUp);
	      });
	    };
	    max.element.addEventListener("animationend", cleanUp);
	  };

	  hexagons.forEach((hexagon) => {
	    hexagon.addEventListener("click", () => {
	      ripple(hexagon, hexagons);
	    });
	  });

	   const switchButton = document.getElementById('switch');
	    const toggleTheme = () => {
	        switchButton.classList.toggle('checked');
	        document.documentElement.classList.toggle('vision-ui');
	    };
	    switchButton.addEventListener('click', toggleTheme);

	    // demo
	    setTimeout(() => {
	    ripple(hexagonElements[0], hexagons);
	    setTimeout(() => {
	      toggleTheme();
	      setTimeout(() => {
	        ripple(hexagonElements[0], hexagons);
	      }, 600);
	    }, 900);
	  }, 300);
	})();
</script>
</body>
</html>