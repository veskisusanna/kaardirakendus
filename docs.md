## Dokumentatsioon meile
### Muutujad
`L` - in Leaflet, `L` is a global object that represents the Leaflet library. It is used to create and manipulate map-related objects, such as tile layers, markers, popups, and controls.

* The first part defines the URLs and attribution information for two map layers, one from OpenStreetMap and the other from CartoDB.

* The `config` object defines the initial configuration of the map, including the default layer and the minimum and maximum zoom levels.

* The `zoom`, `lat`, and `lng` variables define the initial map view.

* The `points array` contains the coordinates and popup text for each marker on the map.

* The `L.map` function creates a new map object with the specified configuration and sets the view to the initial coordinates and zoom level.

* The `L.markerClusterGroup` function creates a new layer group for clustering markers.

* The `markers.addLayer` function adds each marker to the marker cluster group.

* The `L.control.layers` function creates a layer control for switching between the different map layers.

* The `L.control.scale` function creates a scale control for displaying the scale of the map.

* The `L.control.searchbox` function creates a search box control for searching the map.

* The `clickZoom` function centers the map on the clicked marker.



### Code Snippets

```javascript
const osmLink = '<a href="http://openstreetmap.org">OpenStreetMap</a>';
const cartoDB = '<a href="http://cartodb.com/attributions">CartoDB</a>';

const osmUrl = "http://tile.openstreetmap.org/{z}/{x}/{y}.png";
const osmAttrib = `&copy; ${osmLink} Contributors`;
const landUrl =
  "https://{s}.basemaps.cartocdn.com/rastertiles/dark_all/{z}/{x}/{y}.png";
const cartoAttrib = `&copy; ${osmLink} Contributors & ${cartoDB}`;

const osmMap = L.tileLayer(osmUrl, { attribution: osmAttrib });
const landMap = L.tileLayer(landUrl, { attribution: cartoAttrib });
```
The code above sets up two tile layers, one for OpenStreetMap and one for CartoDB, which will be used as base maps in the Leaflet map. The `L.tileLayer()` function creates a new tile layer object with the given URL and options. The `attribution` option specifies the attribution text that should be displayed on the map, which in this case includes links to the respective websites.

***

```javascript
let config = {
  layers: [osmMap],
  minZoom: 5,
  maxZoom: 18,
};
```
The config object specifies the initial configuration of the Leaflet map. Here, we set the initial base layer to osmMap, and set the minimum and maximum zoom levels for the map.

***

```javascript
const zoom = 8;
const lat = 58.636856;
const lng = 25.334473;

const map = L.map("map", config).setView([lat, lng], zoom);
```
This creates a new Leaflet map object with the given configuration, and centers the map view at the given latitude and longitude with the given zoom level. The `setView()` method is used to set the initial view of the map. From here on this `map` obejct will be used to add additional *features* to the map.

***

```javascript
const map = L.map("map", config).setView([lat, lng], zoom);
```
This code creates a Leaflet map object and assigns it to a constant variable named `map`.

The `L.map()` function creates a new map object, where the first argument is the `ID` of the HTML element that the map will be rendered in (in this case, "map"). The config parameter is an optional object that can contain configuration options for the map.

`.setView([lat, lng], zoom)` sets the initial center point and zoom level of the map. `lat` and `lng` are the latitude and longitude coordinates of the center point, respectively. zoom is an integer representing the initial zoom level of the map, with higher numbers representing closer zoom levels.

***

```javascript
osmMap.addTo(map);
```
The `osmMap.addTo(map)` code adds the OpenStreetMap (OSM) layer to the Leaflet map (`map`), which was created in the previous line of code. This means that the OSM layer will now be displayed as a base layer on the Leaflet map.

In Leaflet, you can add multiple layers to a map, and switch between them using layer controls. By adding the OSM layer as a base layer, users can toggle between different base layers (such as satellite imagery or terrain maps) while keeping the OSM layer as a constant reference point.

***
```javascript
let markers = L.markerClusterGroup();
```
The `L.markerClusterGroup()` method creates a marker cluster group that we can add markers to. This group will manage the clustering of markers as we add them to the map.

***
```javascript
for (let i = 0; i < points.length; i++) {
  const [lat, lng, title] = points[i];

  let marker = L.marker(new L.LatLng(lat, lng))
  .bindPopup(title)
  .on("click", clickZoom); //Centers the map when popup is clicked
  markers.addLayer(marker);

}
```
No, the code you provided **does not add** the markers to the **OSM** layer. Instead, it creates a marker for each point in the points array, binds a popup with the title to the marker, and adds each marker to the markers marker cluster group using the addLayer method.

Once all the markers have been added to the marker cluster group, you can add the entire group to the map by using the addLayer method on the map object. For example, if the marker cluster group variable is named markers, you can add it to the map like this:
`map.addLayer(markers);`
This will display all the markers as clusters on the map. When you zoom in, the clusters will break apart into individual markers.

***
```javascript
let baseLayers = {
  "Klassika": osmMap,
  "Värvipime": landMap,
};
```
This code defines an object `baseLayers` that contains two key-value pairs. Each key is a string representing the name of a base layer, and each value is a reference to a previously defined map layer.

In this case, the two base layers are "Klassika" and "Värvipime", which correspond to `osmMap` and `landMap` respectively.

The purpose of this object is to create a list of base layers that can be toggled on and off using a control on the map. This allows the user to switch between different base layers to change the visual appearance of the map.

***

```javascript
L.control.layers(baseLayers).addTo(map);
```
Yes, `L.control.layers()` is used to create a layer control, which allows the user to switch between different base layers. In this case, the `baseLayers` object is passed to the `L.control.layers()` function, which creates a layer control with two options: "Klassika" (the `osmMap` layer) and "Värvipime" (the `landMap` layer). Finally, the `addTo(map)` method is used to add the layer control to the `map` object, so that it is displayed on the map.

***

```javascript
L.control.scale({imperial: false, maxWidth: 100}).addTo(map);
```
This adds the scale to the map. `imperial: false` removes the imperial (only kilometers are on the scale). `maxWidth: 100` sets the width for the scale object in pixels (it is 100 pixels by default - currently unnecessary). Finally `.addTo(map)` will add the scale to the map.

***
**Search functionality**
```javascript
// Searchbox
let searchbox = L.control.searchbox({
    position: 'topright',
    expand: 'left'
}).addTo(map);

// Close and clear searchbox 600ms after pressing ENTER in the search box
searchbox.onInput("keyup", function (e) {
  if (e.keyCode == 13) {
    setTimeout(() => {
      searchbox.hide();
      searchbox.clear();
    }, 600);
  }
});

// Close and clear searchbox 600ms after clicking the search button
searchbox.onButton("click", function () {
  setTimeout(() => {
    searchbox.hide();
    searchbox.clear();
  }, 600);
});
```

This code sets up a search box functionality on the map. The search box is created using the `L.control.searchbox` method and is positioned at the top-right corner of the map.

The `searchbox` object has two event listeners attached to it.

The first listener waits for the `keyup` event on the search box input. When the enter key is pressed (keyCode 13 [`ENTER`]), the function inside the setTimeout method is executed after 600ms. This function hides the search box and clears the input field.

The second listener waits for the search button to be clicked. When clicked, the same function as before is executed after 600ms, which hides the search box and clears the input field.

***

```javascript
// center the map when popup is clicked
function clickZoom(e) {
  map.setView(e.target.getLatLng(), 15); //see siin os veits sus, vahest zoomib liiga sisse
  // pantTo version
  // map.panTo(e.target.getLatLng());
}
```

The `clickZoom` function is defined separately and is used to center the map when a marker's popup is clicked. The `map.setView` method is used to center the map to the clicked marker's position and sets the zoom level to 15.

Overall, this search box functionality allows users to search for locations on the map and centers the map to the clicked location.

***
#### Back to home button
```javascript
// back to home button

const htmlTemplate = '<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 32 32"><path d="M32 18.451L16 6.031 0 18.451v-5.064L16 .967l16 12.42zM28 18v12h-8v-8h-8v8H4V18l12-9z" /></svg>';
// const htmlTemplate = 'img/search_icon.png'

// create custom button
const customControl = L.Control.extend({
  // button position
  options: {
    position: "topleft",
  },

  // method
  onAdd: function (map) {
    console.log(map.getCenter());
    // create button
    const btn = L.DomUtil.create("button");
    btn.title = "tagasi algusesse";
    btn.innerHTML = htmlTemplate;
    btn.className += "leaflet-bar back-to-home hidden";

    return btn;
  },
});

// adding new button to map controll
map.addControl(new customControl());

// on drag end
map.on("moveend", getCenterOfMap);

const buttonBackToHome = document.querySelector(".back-to-home");

function getCenterOfMap() {
  buttonBackToHome.classList.remove("hidden");

  buttonBackToHome.addEventListener("click", () => {
    map.flyTo([lat, lng], zoom);
  });

  map.on("moveend", () => {
    const { lat: latCenter, lng: lngCenter } = map.getCenter();

    const latC = latCenter.toFixed(3) * 1;
    const lngC = lngCenter.toFixed(3) * 1;

    const defaultCoordinate = [+lat.toFixed(3), +lng.toFixed(3)];

    const centerCoordinate = [latC, lngC];

    if (compareToArrays(centerCoordinate, defaultCoordinate)) {
      buttonBackToHome.classList.add("hidden");
    }
  });
}

const compareToArrays = (a, b) => JSON.stringify(a) === JSON.stringify(b);
```
The first step is to create an SVG icon that will serve as the button. This is done using the `const htmlTemplate` variable, which contains the SVG code.
```javascript
const htmlTemplate = '<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 32 32"><path d="M32 18.451L16 6.031 0 18.451v-5.064L16 .967l16 12.42zM28 18v12h-8v-8h-8v8H4V18l12-9z" /></svg>';
```
<br>

Next, a custom control is created using the `L.Control.extend()` method. The custom control is then added to the map using the `map.addControl()` method.
```javascript
const customControl = L.Control.extend({
  // button position
  options: {
    position: "topleft",
  }, 
//...
```
The onAdd method is used to create the button element and set its initial properties. In this method, a new button element is created using L.DomUtil.create(), and its properties are set using the innerHTML and className properties.
```javascript
//...
onAdd: function (map) {
    console.log(map.getCenter());
    // create button
    const btn = L.DomUtil.create("button");
    btn.title = "tagasi algusesse";
    btn.innerHTML = htmlTemplate;
    btn.className += "leaflet-bar back-to-home hidden";

    return btn;
},
});
```
<br>

The `getCenterOfMap` function is called when the `moveend` event is triggered, which happens when the user finishes dragging the map. This function adds an event listener to the "back to home" button that causes the map to fly back to its initial position when the button is clicked.
```javascript
function getCenterOfMap() {
  buttonBackToHome.classList.remove("hidden");

  buttonBackToHome.addEventListener("click", () => {
    map.flyTo([lat, lng], zoom);
  });

  map.on("moveend", () => {
    const { lat: latCenter, lng: lngCenter } = map.getCenter();

    const latC = latCenter.toFixed(3) * 1;
    const lngC = lngCenter.toFixed(3) * 1;

    const defaultCoordinate = [+lat.toFixed(3), +lng.toFixed(3)];

    const centerCoordinate = [latC, lngC];

    if (compareToArrays(centerCoordinate, defaultCoordinate)) {
      buttonBackToHome.classList.add("hidden");
    }
  });
}
```
In addition, `getCenterOfMap` sets up another `moveend` event listener to hide the "back to home" button when the map is moved back to its original position. This is done by comparing the current center of the map with the initial center, and if they match, the button is hidden using the `classList.add()` method.

Finally, the `compareToArrays` function is used to compare two arrays and returns true if they are equal. This is used to compare the current center of the map with the initial center.
```javascript
const compareToArrays = (a, b) => JSON.stringify(a) === JSON.stringify(b);
```

***

